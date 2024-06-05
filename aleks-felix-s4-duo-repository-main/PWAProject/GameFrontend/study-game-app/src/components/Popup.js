import fight from "../images/Fight.png";
import classes from "../css/transition.module.css";
import { useState, useEffect } from "react";
import {Howler} from "howler";
import fightMp3 from "../images/Fight.mp3";
import SoundPlayer from "../services/Hardware/SoundPlayer";

function Popup(){
    const [isTrue, setIsTrue] = useState(true);

    const fightSound = SoundPlayer.getSound(fightMp3);
    Howler.volume(1);

    useEffect(()=>{
        fightSound.play();
    },[])

    useEffect(()=>{
        setInterval(()=>{
           setIsTrue(false);
        },4500)
    },[])

    return (
        <div className={isTrue ? classes.comp : classes.destroyed}>
            <img className={classes.popup} src={fight}/>
        </div>
    )
}

export default Popup;