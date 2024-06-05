import axios from 'axios';

const QUESTION_API_BASE_URL = "https://fantasy-study-game-backend-v1.herokuapp.com/question";

class QuestionAPICalls {
	getEasyQuestion(){
		return axios.get(QUESTION_API_BASE_URL+"/easy");
	}

    getMediumQuestion(){
		return axios.get(QUESTION_API_BASE_URL+"/medium");
	}

    getHardQuestion(){
		return axios.get(QUESTION_API_BASE_URL+"/hard");
	}

}

export default new QuestionAPICalls()