<script setup>

</script>

<script>
export default {
  props: ['title', 'imgSrc', 'id']
}
</script>

<template>
    <router-link class="item" :to="{ name: 'ArtistProjectSingleManagePreset', params: { preset: id }}">
        <img :src=imgSrc alt=""/>
        <span>{{title}}</span>
    </router-link>
</template>

<style lang="scss" scoped>
    @import './../../../../scss/variables';

    .item {
        width: 160px;
        display: flex;
        flex-direction: column;
        align-items: center;
        border-radius: 20px;
        overflow: hidden;
        margin-right: 20px;
        flex: 1 0 160px;
        img {
          width: 100%;
          height: 130px;
          min-height: 130px;
          object-fit: cover;
        }
        span {
          display: flex;
          width: 100%;
          height: 100%;
          background: $dark;
          color: $white;
          justify-content: center;
          padding: 20px 0;
        }
      }
</style>