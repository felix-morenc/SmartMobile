<template>
  <div class="votingPopup">
    <div class="grid-container" id="votingHeader" v-on:click="OpenOptions()">
      <div class="item1"><Countdown :hours="hours" :minutes="minutes" @onFinish="finish()"></Countdown></div>
      <div class="item4">
        <span class="votingText">new voting round</span>
        <p class="votingText votingName">{{this.votingName}}</p> 
      </div>
      <div class="item4 closeVoting"><i class="fa fa-times fa-2x" aria-hidden="true" v-on:click="ClosePopUp()"></i></div>
    </div>
    <div class="allOptions" v-if="showOptions== true">
      <VotingOptions v-for="option in Vote.items" :key="option" :image="option.image" :name="option.name" :color="option.borderColor" :id="option.name" v-on:click="ChangeColor(option.name)"/>
    </div>
    <button class="voteButton" v-if="confirmButton== true" v-on:click="finish()">Submit Vote</button>
    
  </div>
</template>

<script>
import Countdown from "../components/Countdown.vue";
import VotingOptions from "../components/VotingOption.vue";
import axios from 'axios'
export default {
  components: {
    Countdown,
    VotingOptions,
  },
  props: {
    hours: null,
    minutes: null,
    voteOptions: null
  },
  data(){
    return{
      Event: {
        Id: "",
        Name: "test",
      },
      votingName: "Lights",
      showOptions: this.openOptions,
      confirmButton: false,
      counting: false,
      hours: this.hours,
      minutes: this.minutes,
      options: [],
      lights: {
        name: "Rock The City",
        image: "https://www.kinetic-lights.com/wordpress/wp-content/uploads/2019/10/SKALAR-Thumb.jpg",
        borderColor: "white"
      },
      lights2: {
        name: "Rock The suburbs",
        image: "https://www.kinetic-lights.com/wordpress/wp-content/uploads/2019/10/SKALAR-Thumb.jpg",
        borderColor: "white"
      },
      color: "#FFC400",
      Vote: {
        name: "",
        id: "",
        itemId: "",
        items: [],
      }
    }
  },
  methods: {
    finish() {
      this.Vote.items.forEach(option => {
        if(option.borderColor == "blue"){
           axios.put('https://api-backend-v1.herokuapp.com/place/0/'+ option.id, { vote: this.Vote }).then(
            (response) =>{
              console.log(response)
            }
           );
        }
      })
      this.ClosePopUp()
    },
    ChangeColor(name){
      this.Vote.items.forEach(option => {
        if(option.name == name){
          option.borderColor = "blue"
        }else{
          option.borderColor = "white"
        }
      });
      this.confirmButton = true;
    },
    OpenOptions(){
      this.showOptions = true
      var header = document.getElementById("votingHeader")
      header.style.borderBottomRightRadius = "0px"
      header.style.borderBottomLeftRadius = "0px"
      const _self = this
      _self.$emit('blur')
    },
    ClosePopUp(){
      const _self = this
      this.showOptions = false
      _self.$emit('closePopup')
    },
  },
  mounted(){
    this.Event.Id = this.$route.params.Id
    axios.get("https://api-backend-v1.herokuapp.com/getVote/0").then(
      (response) => {
       this.Vote = response.data
       this.Vote.items.forEach(item => {
          item.borderColor = "white"
       });
      })
  }
}
</script>

<style scoped>
.allOptions{
  display: flex;
    flex-direction: row;
    flex-wrap: wrap;
}
.grid-container1 {
  display: grid;
}

.grid-container {
  display: grid;
  grid-gap: 10px;
  background-color: #FF8500;
  padding: 10px;
  border-top-left-radius: 20px;
  border-top-right-radius: 20px;
  border-bottom-left-radius: 20px;
  border-bottom-right-radius: 20px;
}

.votingPopup{
  width: 100%;
}
.votingText{
 font-style: 16px !important;
 color: white;
}
.votingName{
 margin: 0px;
}

.item1 {
  grid-row: 1 / span 1;
}
.item3{
 grid-row: 1 / span 1;
}
.item4{
  grid-row: 1 / span 1;
}

.closeVoting{
  color: white;
}

.voteButton{
  font-size: 20px;
  margin-bottom: 5px;
  background-color: #8637C8;
  border-color: black;
  border-radius: 10px;
  border-style: solid;
  border-width: 5px;
}
</style>