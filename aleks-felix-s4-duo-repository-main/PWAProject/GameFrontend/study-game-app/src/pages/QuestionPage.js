import { useEffect, useState } from "react";
import BattleAPICalls from "../services/APICalls/BattleAPICalls";
import QuestionAPICalls from "../services/APICalls/QuestionAPICalls";
import classes from "../css/QuestionPage.module.css";
import HealthSystem from "../components/HealthSystem";
import {useLocation, useNavigate} from 'react-router-dom';

function QuestionPage(){

    const [healthBars, setHealthBars] = useState(null);
    const [answers, setAnswers] = useState([]);
    const [question,setQuestion] = useState("");
    const [seconds, setSeconds] = useState(0);
    const [questionObj,setQuestionObj] = useState(null);
    const [phase, setPhase] = useState(null);


    const location = useLocation();
    const navigate = useNavigate();
    let secondsPassed = 0;

    useEffect(()=>{
        BattleAPICalls.getHealthBars().then((res) => {
          console.log(res.data);
          setHealthBars(res.data);
        }).catch((err)=>{console.log(err);})
      },[phase]);

      useEffect(()=>{
        setInterval(()=>{           
            setSeconds(secondsPassed+=1);      
            
        },1000)
      },[])

      useEffect(()=>{
        if(healthBars !=null){
            if(healthBars[0] ==0  || healthBars[1] ==0)
            navigate('/battle',{state:{name:location.state.name, phase:true}});
        }
      },[seconds])

    useEffect(()=>{
        console.log(location.state.name)
        setPhase(location.state.phase)
        if(location.state.name === "easy")
        {
            QuestionAPICalls.getEasyQuestion().then((res) => {
                setQuestionObj(res.data);
                setAnswers(res.data.possibleAnswers);
                setQuestion(res.data.question);
            }).catch((err)=>{console.log(err);})
        }
        else if(location.state.name === "medium")
        {
            QuestionAPICalls.getMediumQuestion().then((res) => {
                setQuestionObj(res.data);
                setAnswers(res.data.possibleAnswers);
                setQuestion(res.data.question);
            }).catch((err)=>{console.log(err);})
        }
        else if(location.state.name === "hard")
        {
            QuestionAPICalls.getHardQuestion().then((res) => {
                setQuestionObj(res.data);
                setAnswers(res.data.possibleAnswers);
                setQuestion(res.data.question);
            }).catch((err)=>{console.log(err);})
        }
        else{
            QuestionAPICalls.getEasyQuestion().then((res) => {
                //console.log(res.data);
                //console.log(res.data.question);
                setQuestionObj(res.data);
                setAnswers(res.data.possibleAnswers);
                setQuestion(res.data.question);
                //console.log(answers)
                //console.log(res.data.possibleAnswers[0]);
                //console.log(res.data.possibleAnswers[1]);
                //console.log(res.data.possibleAnswers[2]);
            }).catch((err)=>{console.log(err);})
        }
    })

    const handleAnswer = (answer) => () => {
        if(answer === true)
        {
            console.log(questionObj);
            if(phase === true)
            {
                if(seconds <= 5)
                {
                    questionObj.doubleDamage=true
                }
                BattleAPICalls.attack(questionObj);
                navigate('/QuestionPage',{state:{name:location.state.name, phase:false}});
            }
            else
            {
                navigate('/battle',{state:{name:location.state.name, phase:true}});
            }
            
        }
        else
        {
            if(phase === false)
            {
                BattleAPICalls.defend(questionObj);
                navigate('/battle',{state:{name:location.state.name, phase:true}});
            }
            else
            {
                navigate('/QuestionPage',{state:{name:location.state.name, phase:false}});
            }
            
        }
      };

    return (
       <div className={classes.comp}>
            <div className={classes.scroll}>
                {healthBars!=null ? <HealthSystem healthBars={healthBars}/> : <div>No healthBars</div>}
                <div className={classes.background}>
                    <div className={classes.question}>{phase===true ? "Attack" : "Defend" }</div>
                    <div className={classes.question}>{question}</div>
                </div>
                <div className={classes.attacks}>
                    <p>Answers</p>
                    <div className={classes.attackButtons}>
                    {answers.map((answer) =>{
                        return(
                            <button className={classes} onClick={handleAnswer(answer.correct)}>{answer.answer}</button>
                        );
                        
                    })}
                    </div>
                </div>
            </div>
       </div>
    )
}

export default QuestionPage;