..<template>
  <div class="LocationPopup" id="LocationHeader" v-on:click="OpenLivestream(this.evenInfo)">
    <div class="grid-container">
        <div class="grid-icon-1">
            <i class="fa fa-map-marker fa-2x" aria-hidden="true"></i>
        </div>
        <div class="grid-text-1">
            <h3 class="LocationName">{{this.Name}}</h3>
            <p class="LocationArea">Grotezaal</p>
        </div>
        <div class="grid-icon-2">
            <i class="fa fa-music fa-2x" aria-hidden="true"></i>
        </div>
        <div class="grid-text-2">
            <h3 class="LocationArtist">Douwe Bob</h3>
            <p class="LocationTime">20:00 - 21:30</p>
        </div>
        <div class="grid-icon-3">
            <i class="fa fa-eur fa-2x" aria-hidden="true"></i>
        </div>
        <div class="grid-text-3">
            <h3 class="LocationPrice">Free</h3>
        </div>
        <div class="grid-image-1">
        <img id="locationPlaceholder" src="./../assets/effenaar.jpeg"/>
        <i id="closePopup" class="fa fa-times fa-2x" aria-hidden="true" v-on:click="ClosePopup()"></i>
        </div>
    </div>
</div>
</template>

<script>
export default {
     props: {
        Eventname: null,
        event: null,
    },
    data(){
        return{
          Name: this.Eventname,
          evenInfo: {
            eventName: this.event.name, //Effenaar
            eventId: this.event.id,
            markerLocation: {
              posX: this.event.eventLocation.postiionX,
              posY: this.event.eventLocation.positionY
            },
          },
        }
    },

    methods: {
        OpenLivestream(marker) {
          console.log(marker)
        this.$router.push({
            name: "LiveStream",
            params: {id: marker.eventId, event: JSON.stringify(marker)},
        })
        },
        ClosePopup(){
            const _self = this
            _self.$emit('close')
        }
    },
}
</script>

<style scoped>


.LocationPopup {
  position: fixed;
  bottom: 0;
    background: rgb(157,78,221);
    background: linear-gradient(90deg, rgba(157,78,221,1) 100%, rgba(123,44,191,1) 100%);
    padding-left: 10px;
  border-radius: 20px;
  text-align: left;
  color: #fff;
  z-index: 51;
  margin: 15px;
  box-shadow: 0px 0px 30px 1px #8737c899;
}

.grid-icon-1 {
  grid-area: icon1;
  display: flex;
  justify-content: center;
  align-items: center;
}

.grid-text-1 {
  grid-area: text1;
  padding-left: 10px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.grid-icon-2 {
  grid-area: icon2;
  display: flex;
  justify-content: center;
  align-items: center;
}

.grid-text-2 {
  grid-area: text2;
  padding-left: 10px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.grid-icon-3 {
  grid-area: icon3;
  display: flex;
  justify-content: center;
  align-items: center;
}

.grid-text-3 {
  grid-area: text3;
  padding-left: 10px;  
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.grid-image-1 {
  grid-area: image1;
  float: right;
  object-fit: cover;
  height: 100%;
  width: 100%;
  position: relative;
}

.grid-container{
    display: grid;
    grid-template-columns: 10% 40% 50%;
  grid-template-rows: auto;
  grid-template-areas: 
    "icon1 text1 image1"
    "icon2 text2 image1"
    "icon3 text3 image1";
}

#locationPlaceholder{
    width: 100%;
    height: 100%;
    object-fit: cover;
    border-top-right-radius: 20px;
    border-bottom-right-radius: 20px;
}

p{
    margin-top: -20px;
}

#closePopup{
    text-align: right;
    display: flex;
  flex-direction: column;
  justify-content: center;
  position: absolute;
  top: 15px;
  right: 20px;
}
</style>