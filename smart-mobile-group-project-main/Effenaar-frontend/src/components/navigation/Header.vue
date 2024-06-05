<script>
import Navigation from './Navigation.vue'

export default {
  data() {
    return {
      title: 'Dashboard',
      transparent: false, // transparent background
      dark: false,
      navActive: false,
    }
  },
  components: {
    Navigation
  }
}
</script>

<template>
  <header class="header" :class="{ transparent: transparent, dark: dark }">
      <div class="header-action" @click="navActive = !navActive" :class="{active: navActive}">
          <span class="burger-icon"></span>
      </div>
      <div class="header-center">
          <span>{{$data.title}}</span>
      </div>
  </header>
  <Navigation :class="{active: navActive}" />
</template>

<style lang="scss" scoped>
    @import './../../../scss/variables';

    .header {
        background: $dark;
        color: $white;
        display: flex;
        align-items: center;
        z-index: 555;
        position: fixed;
        width: 100%;
        top:0;
        .header-action {
          aspect-ratio: 1/1;
          flex: 0 0 50px;
          display: flex;
          justify-content: center;
          align-items: center;
          transition: 200ms;
          .burger-icon {
            display: flex;
            width: 20px;
            height: 20px;
            justify-content: center;
            align-items: flex-start;
            flex-direction: column;
            transition: inherit;
            &:after,&:before {
              content: '';
              width: 100%;
              height: 3px;
              background: $white;
              border-radius: 10px;
              margin: 2px 0;
              transition: inherit;
            }
            &:after {
              width: 65%;
            }
          }
          &.active {
            .burger-icon{
              &:after {
                width: 100%;
                transform: rotate(-45deg);
                margin: -1.5px 0;
              }
              &:before {
                transform: rotate(45deg);
                margin: -1.5px 0;
              }
            }
          }
        }
        .header-center {
          margin-right: 50px;
          justify-self: center;
          flex: 1;
          text-align: center;
        }
    }
</style>