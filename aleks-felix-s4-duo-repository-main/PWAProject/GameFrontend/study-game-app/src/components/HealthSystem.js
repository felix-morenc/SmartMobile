import { useEffect, useState } from "react";
import classes from "../css/HealthSystem.module.css";
import ko from "../images/vs.png";

function HealthSystem(props){

    const [seconds, setSeconds] = useState(0);
    const [minutes, setMinutes] = useState(0);

    let secondsPassed = 0;
    let minutesPassed = 0;
    useEffect(()=>{
        setInterval(()=>{
            if(secondsPassed<=58){
                setSeconds(secondsPassed+=1);
            }
            else{
                secondsPassed=0;
                minutesPassed++;
                setSeconds(secondsPassed);
                setMinutes(minutesPassed);
            }
            
        },1000)
    },[])

    function setMinutesPart(){
        if(minutes<10){
            return "0"+minutes;
        }
        return minutes;
    }

    function healthChecker(health){
        if(health>125){
            return "green";
        }
        else if( health<125 && health>55){
            return "#fec821";
        }
        else {
            return "red";
        }
    }

    const styleHero = {"transition":"1s ease","transitionDelay": "0.2s",'background': healthChecker(props.healthBars[0]),"borderRadius": "50px", 'width':props.healthBars[0]/2 +'px',"height":"1.5rem"}
    const styleEnemy = {"transition":"1s ease","transitionDelay": "0.2s",'background': healthChecker(props.healthBars[1]),"borderRadius": "50px", 'width':props.healthBars[1]/2 +'px',"height":"1.5rem"}

    function setSecondsPart(){
        if(seconds<10){
            return "0"+seconds;
        }
        return seconds
    }

    return (
        <div className={classes.comp}>
            <div className={classes.healtbars}>
                <div className={classes.hero}>
                    <p className={classes.name}>Kakshi</p>
                    <div className={classes.bar}>
                        <div style={styleHero}>{props.healthBars[0]}</div>
                    </div>
                </div>
                <img className={classes.ko} src={ko}/>
                <div className={classes.enemy}>
                    <p className={classes.name}>Pain</p>
                    <div className={classes.bar}>
                        <div style={styleEnemy}>{props.healthBars[1]}</div>
                    </div>
                </div>
            </div>
            <div className={classes.timer}>
                {setMinutesPart() + ":" + setSecondsPart()}
            </div>
        </div>
    )
}

export default HealthSystem;