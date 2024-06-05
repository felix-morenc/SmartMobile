import classes from "../css/EndBattle.module.css";
import { Link } from "react-router-dom";
import BattleAPICalls from "../services/APICalls/BattleAPICalls";
import { useEffect, useState } from "react";
import koSound from "../images/KO.mp3"
import SoundPlayer from "../services/Hardware/SoundPlayer";
import {Howler} from "howler";

function EndBattle(){

    const [res, setRes] = useState(null);
    const ko = SoundPlayer.getSound(koSound);
    ko.play();
    Howler.volume(1);
    
    useEffect(()=>{
      BattleAPICalls.getHealthBars().then((res)=>{
        console.log(res);
        if(res.data[0]==0){
          setRes("DEFEAT");
        }
        else if(res.data[1]==0){
          setRes("VICTORY");
        }
      }).catch()
    },[])

    return (
        <div className={classes.comp}>
           <div className={classes.scroll} >
            <p className={classes.victory}>{res !=null ? res : "...."}</p>
                <div className={classes.buttons}>
                    <button><div></div><p className={classes.buttonText}>Next Battle</p></button>
                    <button><div></div><p className={classes.buttonText}><Link className={classes.buttonText} to="/">Go Back</Link></p></button>
                </div>
           </div>
        </div>
    )
}

export default EndBattle;