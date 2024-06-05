<script setup>
import { ref,onMounted } from 'vue'

// References for getting divs
const mapWrapper = ref()
const map = ref()

// TODO: replace with API data
const markerData = [
  {
    "eventName": "Effenaar", //Effenaar
    "eventId": "EID329JLEI",
    "markerLocation": {
      "posX": 1490,
      "posY": 970
    },
  },
  {
    "eventName": "Dynamo", //Dynamo
    "eventId": "IEI436JEIO",
    "markerLocation": {
      "posX": 1020,
      "posY": 960
    },
  },
    {
    "eventName": "", //Fifth
    "eventId": "",
    "markerLocation": {
      "posX": 1460,
      "posY": 1285
    },
  },
      {
    "eventName": "", //Altstadt
    "eventId": "",
    "markerLocation": {
      "posX": 950,
      "posY": 1150
    },
  },
      {
    "eventName": "", //De Rozenknop
    "eventId": "",
    "markerLocation": {
      "posX": 530,
      "posY": 1360
    },
  },
      {
    "eventName": "", //Cafe Wilhelmina
    "eventId": "",
    "markerLocation": {
      "posX": 0,
      "posY": 1090
    },
  },
      {
    "eventName": "", //Stoomhuis
    "eventId": "",
    "markerLocation": {
      "posX": 820,
      "posY": 540
    },
  },
]

onMounted(() => {
  // Scroll to center of the mapwrapper
  mapWrapper.value.scrollTo(
    1000 - mapWrapper.value.clientWidth / 2, 
    1000 - mapWrapper.value.clientHeight / 2
  )
})

</script>

<script>
import LocationPopup from "../components/LocationPopup.vue";
import axios from 'axios'
export default {
    components: {
        LocationPopup,
    },
  data(){
    return{
      showLocationPopup: false,
      event: {
        eventName: "Test", //Effenaar
        eventId: "EID329JLEI",
        eventLocation: {
          positionX: 1490,
          positionY: 970
        },
      },
      markers: [],
    }
  },

  methods: {
    OpenLocation(marker){
      this.showLocationPopup = true;
      this.event = marker
    },
    ClosePopup(){
        this.showLocationPopup = false;
    },
    markerClick(marker) {
      this.$router.push({
        name: "LiveStream",
        params: {id: marker.eventId, event: JSON.stringify(marker)},
      })
    },
  },
  mounted(){
    this.showLocationPopup = false;
    axios.get("https://api-backend-v1.herokuapp.com/project/get/all/projects").then(
      (response) => {
        this.markers = response.data
      })
  }
}
</script>

<template>
  <div class="map-wrapper" ref="mapWrapper">
    <LocationPopup class="locationPopup" v-if="showLocationPopup == true" :Eventname="'Effenaar'" :event="event" @close="ClosePopup()"/>
    <div class="map-marker-container">
        <div class="map-marker" v-for='marker in markers' :key="{marker}" v-on:click="OpenLocation(marker)" v-bind:style="{
          'left': marker.eventLocation.positionX+'px',  // left: ___px;
          'top': marker.eventLocation.positionY+'px'    // top: ___px;
        }"></div>
    </div>
    <div class="map" ref="map">
      <video autoplay loop muted>
          <source src="./../assets/map.webm" type="video/webm" >
        Your browser does not support the video tag.
      </video>
    </div>
  </div>
</template>

<style lang="scss" scoped>
  
  .map-wrapper {
    width: 100%;
    height: 100vh;
    position: relative;
    overflow: scroll;
    .map,
    .map-marker-container {
      position: absolute;
      left: 0;
      top: 0;
      width: 2000px;
      aspect-ratio: 1/1;
    }
    .map {
      video {
        width: 100%;
        height: 100%;
        object-fit: cover;
        z-index: 1;
        position: relative;
      }
    }

    .map-marker-container {
      z-index: 50;
      .map-marker {
        width: 150px;
        height: 150px;
        border-radius: 50%;
        position: absolute;

      //uncomment this to make the markers visible 
        // border: rgb(255, 0, 212);
        // border-style: solid;
        // border-width: 2px;
      }
    }
  }

</style>