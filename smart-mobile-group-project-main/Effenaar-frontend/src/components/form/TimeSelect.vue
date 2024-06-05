<script setup>
    
</script>
<script>
export default {
    data() {
        return {
            interval: "00:00:30"
        }
    },
    methods: {
        addTime() {
            let minutesAppend = '';
            const date = new Date("December 30, 2017 " + this.interval);
            date.setSeconds( date.getSeconds() + 15 );
            let seconds = date.getSeconds();
            if(seconds == 0) {
                seconds = '00';
            }
            if(date.getMinutes() < 10) {
                minutesAppend = '0';
            }
            this.interval = '0' + date.getHours() + ':' + minutesAppend + date.getMinutes() +':'+ seconds;
        },
        removeTime() {
            let minutesAppend = '';
            const date = new Date("December 30, 2017 " + this.interval);
            date.setSeconds( date.getSeconds() - 15 );
            let seconds = date.getSeconds();
            if(date.getMinutes() == 0 && date.getMinutes() == 0 && date.getSeconds() < 30) {
                return;
            }
            if(seconds == 0) {
                seconds = '00';
            }
            if(date.getMinutes() < 10) {
                minutesAppend = '0';
            }
            this.interval = '0' + date.getHours() + ':' + minutesAppend + date.getMinutes() +':'+ seconds;
        }
    }
};

    

</script>

<template>
    <div class="time-select">
        <label for="appt" class="time-input-label">Select time interval for voting</label>
        <div class="time-input-wrapper">
            <button class="modify-time-button" @click="removeTime()">-</button>
            <input v-model="interval" type="time" id="appt" class="time-input" min="00:00:30" name="appt" required>
            <button class="modify-time-button" @click="addTime()">+</button>
        </div>
    </div>
</template>

<style lang="scss" scoped>
    @import './../../../scss/variables';

    .time-select {
        display: flex;
        flex-direction: column;
        .time-input-label {
            font-size: 14px;
            font-style: italic;
            margin-bottom: 5px;
        }
        .time-input-wrapper {
            display: flex;
            border-radius: 5px;
            overflow: hidden;
            .time-input {
                flex-grow: 1;
                border: 0;
                appearance: none;
                padding: 0 20px;
            }
            .modify-time-button {
                appearance: none;
                background: $primary;
                padding: 14px 20px;
                color: $white;
                border: none;
            }
        }
    }
</style>