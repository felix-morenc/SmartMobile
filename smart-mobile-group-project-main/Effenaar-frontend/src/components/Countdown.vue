<template>
  <div v-if="finish == false" class="countdown">
    <div class="countdown__block">
      <div class="countdown__digit">{{ timeLeftMinutes }}</div>
    </div>
     <div class="countdown__block">
      <div class="countdown__digit">{{ timeLeftSeconds }}</div>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    hours: null,
    minutes: null,
  },
  data () {
    return {
      interval: this.time,
      startHour: this.time,
      startMinute: this.time,
      endHour: this.hours,
      endMinute: this.minutes,
      endSecond: 0,
      finish: false,
      hoursNow: Math.trunc((new Date()).getHours()),
      minutesNow: Math.trunc((new Date()).getMinutes()),
      secondsNow:  Math.trunc((new Date()).getSeconds()),
    }
  },
  mounted () {
    const _self = this
    this.startHour = Math.trunc((new Date()).getHours())
    this.startMinute = Math.trunc((new Date()).getMinutes())
    window.setInterval(() => {
        this.hoursNow = Math.trunc((new Date()).getHours())
        this.minutesNow = Math.trunc((new Date()).getMinutes())
        this.secondsNow =  Math.trunc((new Date()).getSeconds())
        if(!this.finish && this.hoursNow >= this.endHour && this.minutesNow >= this.endMinute){
            console.log("het is klaar")
            _self.finish = true
            _self.$emit('onFinish')
        }
    }, 1000)
  },
  computed: {
    timeLeftMinutes(){
        var result = 0
        var totalHours = 0
        if(this.endHour - this.hoursNow  > 0){
            totalHours = (this.endHour - this.hoursNow) * 60
        }
        result = this.endMinute - this.minutesNow - 1
        if(totalHours > 0){
            result = result + totalHours
        }
        if(result > 0){
            return result
        }
        else{
            return 0
        }
    },
    timeLeftSeconds(){
        var result = 0
        result = this.endSecond - this.secondsNow 
        if (result > 0){
            return result
        }else{
            result = 60 + result
            return result
        }
    },
  },
}
</script>
<style lang="scss">
.countdown{
  display: flex;
  justify-content: center;
  &__block {
    text-align: center;
    padding: 0px 10px;
    position: relative;
    &:first-child{
      padding-left: 0;
      .countdown__digit{
        &:before{
          display: none;
        }
      }
    }
    &:last-child{
      padding-right: 0;
    }
  }
  &__digit {
    color: white;
    font-size: 25px;
    line-height: 1;
    &:before{
      content: ":";
      position: absolute;
      left: -5px;
    }
  }
}
</style>
