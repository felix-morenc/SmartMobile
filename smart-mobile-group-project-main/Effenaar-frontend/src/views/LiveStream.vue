<template>
    <div>
       <iframe class="liveStream" id="liveStream" width="560" height="315" src="https://www.youtube.com/embed/y0k8Akk1yN0?controls=0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        <header class="wrapper">
        <i class="backIcon fa fa-arrow-left fa-2x" aria-hidden="true" v-on:click="backToMap()"></i>
        <p class="streamText">{{this.event.eventName}}</p>
        <i class="voteIcon fa fa-check-square-o fa-2x" aria-hidden="true" v-on:click="openPopup()"></i>
        </header>
        <Voting class="votingpopup" :hours="hours" :minutes="minutes" :voteOptions="event.Items" v-if="this.showVoting == true" @blur="openBlur()" @closePopup="closePopup()"/>
    </div>
</template>

<script>
import Header from '../components/navigation/Header.vue';
import Voting from "../views/Voting.vue";
export default {
    components: {
        Voting,
        Header,
    },
    data(){
        return {
            showVoting: false,
            hours: 0,
            minutes: 0,
            event: {
                eventName: "",
                eventId: "",
                markerLocation: {
                    posX: 0,
                    posY: 0,
                },
                Items: [],
            },
            stream: "https://c.tenor.com/EKoIUuYBFmcAAAAC/music-concert.gif",
        }
    },
    methods: {
        openPopup() {
            this.showVoting = true
        },
        openBlur(){
            var livestream = document.getElementById("liveStream")
            livestream.style.filter = "blur(4px)"
        },
        closePopup() {
            this.showVoting = false
            var livestream = document.getElementById("liveStream")
            livestream.style.filter = "blur(0px)"
            this.getNewTime()
        },
        getNewTime(){
            var newTime = 15
            var newMinutes = this.minutes
            if(newTime > this.hours){
                this.hours = newTime
                setTimeout(() => {  this.openPopup() }, 6000);
                console.log(this.hours)
            }else if(newTime == this.hours && newMinutes > this.minutes){
                this.hours = newTime
                setTimeout(() => {  this.openPopup() }, 6000);
            }
        },
        backToMap(){
            this.$router.push({name: "Home"})
        },
    },
    mounted(){
        this.hours = 14
        this.minutes = 28
        this.event = JSON.parse(this.$route.params.event)
        console.log(this.event)
        if(this.event.eventId == "EID329JLEI"){
            this.stream = "https://www.gifs.nl/media/awesome-gifs-Zyicsg.gif"
        }
        if(this.hours > Math.trunc((new Date()).getHours())){
            this.openPopup()
        }else if (this.minutes > Math.trunc((new Date()).getMinutes()) && this.hours == Math.trunc((new Date()).getHours())){
            this.openPopup()
        }
    },
}
</script>

<style scoped>
.liveStream{
    max-width: 100%;
    height: 100vh;
    object-fit: cover;
    filter: blur(0px);
}
.streamText{
    color: white;
    font-size: 25px;
}
.wrapper{
  position: fixed;
    display: flex;
    justify-content: space-between;
    width: 100%;
    top: 0%;
    padding: 15px 35px;
    align-items: center;
    box-sizing: border-box;
    left: 0;
    background: linear-gradient(180deg,rgba(0, 0, 0, 0.434),rgba(0, 0, 0, 0));
    z-index: 999;
}
.backIcon{
    color: white;
    font-size: 25px;
}
.votingpopup{
    max-width: 90%;
    position: absolute;
    top: 20%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #FF9E00;
    border-radius: 20px;
    z-index: 999;
}
.voteIcon{
    color: white;
}
</style>