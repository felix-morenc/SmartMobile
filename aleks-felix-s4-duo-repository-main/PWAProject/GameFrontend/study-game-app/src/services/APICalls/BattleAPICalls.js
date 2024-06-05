import axios from 'axios';

const BATTLE_API_BASE_URL = "https://fantasy-study-game-backend-v1.herokuapp.com/battle";

class BattleAPICalls {
	getHealthBars(){
		return axios.get(BATTLE_API_BASE_URL+"/health");
	}

    attack(question){
		return axios.post(BATTLE_API_BASE_URL+"/attack",question);
	}

    defend(question){
		return axios.post(BATTLE_API_BASE_URL+"/defend",question);
	}

	refreshHealthPoints(){
		return axios.post(BATTLE_API_BASE_URL+"/refresh/points");
	}

}

export default new BattleAPICalls()