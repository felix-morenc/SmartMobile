import classes from "../css/home.module.css";
import hero from "../images/Enemy.png";
import {FaShare } from 'react-icons/fa';
import { RWebShare } from "react-web-share";
import BattleAPICalls from "../services/APICalls/BattleAPICalls";
import { useEffect } from "react";
import {Link, useNavigate, useLocation} from 'react-router-dom';



function Home() {

  useEffect(()=>{
    BattleAPICalls.refreshHealthPoints().then((res) => {
        console.log(res.data);
      }).catch((err)=>{console.log(err);})
},[]);

    const navigate = useNavigate();

    const toBattlePage=()=>{
        navigate('/battle',{state:{phase:true, isFirst:true}});
    }


    return (
      <div className={classes.comp}>
        <div className={classes.scroll} >
            <p className={classes.victory}>WANTED</p>
            <img className={classes.hero} src={hero}></img>
        </div>
        <div className={classes.buttons}>
            <button onClick={()=>{toBattlePage()}}><div></div><p className={classes.buttonText}>Fight</p></button>
            <RWebShare data={{
          text: "Web Share - GfG",
          url: "https://fantasy-study-game-v1.herokuapp.com/",
          title: "GfG",
        }}
        onClick={() => console.log("shared successfully!")}
      >
                <button><div></div><p className={classes.buttonText}><FaShare/> Share</p></button>
            </RWebShare>
        </div>
     </div>
      );
}

  export default Home;