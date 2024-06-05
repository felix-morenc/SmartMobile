import { useEffect, useState } from "react";
import BattleAPICalls from "../services/APICalls/BattleAPICalls";
import {FaArrowAltCircleLeft, FaVolumeMute } from 'react-icons/fa';
import classes from "../css/BattleScenePage.module.css";
import HealthSystem from "../components/HealthSystem";
import SoundPlayer from "../services/Hardware/SoundPlayer";
import {Howler} from "howler";
import sabaton from "../images/sabaton.mp3";
import {useLocation, useNavigate} from 'react-router-dom';
import EndBattle from "../components/EndBattle";
import Fight from "../components/Popup";

function BattleScenePage(props){

    const location = useLocation();
    const [healthBars, setHealthBars] = useState(null);
    const [isKOd, setIsKOd] = useState(false);
    const sound = SoundPlayer.getSound(sabaton);
    const navigate = useNavigate();
    const [phase, setPhase] = useState(null);
    
    useEffect(()=>{
        BattleAPICalls.getHealthBars().then((res) => {
            console.log(res.data);
            setHealthBars(res.data);
        }).catch((err)=>{console.log(err);})
        setPhase(location.state.phase);
    },[]);

    const toAttackPage=(difficulty)=>{
        navigate('/QuestionPage',{state:{name:difficulty, phase:phase}});
    }
    useEffect(()=>{      
        if(healthBars !=null){
            if(healthBars[0] ==0  || healthBars[1] ==0)
                setIsKOd(true);
        }
    },[healthBars])

    Howler.volume(1);

    return (
        <div className={classes.comp}>
            {location.state.isFirst === true ? <Fight/> : null}
            <div className={classes.top}>
                <button onClick={()=>{navigate("/")}} className={classes.goback}><FaArrowAltCircleLeft/></button>
                <button className={classes.sound} onClick={()=>{SoundPlayer.musicHandler(sound)}}>{<FaVolumeMute/>}</button>
            </div>
            <div className={classes.scroll}>
                {healthBars!=null ? <HealthSystem healthBars={healthBars}/> : <div>No healthBars</div>}
                <div className={classes.background}>
                    <div className={classes.hero}></div>
                    <div className={classes.enemy}></div>
                </div>
                <div className={classes.attacks}>
                    <p>Attacks</p>
                    <div className={classes.attackButtons}>
                        <button onClick={()=>{toAttackPage("easy")}}>20 damage</button>
                        <button onClick={()=>{toAttackPage("medium")}}>40 damage</button>
                        <button onClick={()=>{toAttackPage("hard")}}>60 damage</button>
                    </div>
              </div>
            </div>
            {isKOd == true? <EndBattle/> : null}
        </div>
    )
}

export default BattleScenePage;