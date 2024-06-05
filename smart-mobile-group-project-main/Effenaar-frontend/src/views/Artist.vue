<script>
    import Header from "../components/navigation/Header.vue";

    export default {
    components: {
        Header
    }
    }
</script>

<template>
  <Header />
  <div class="container admin">
    <router-view></router-view>
  </div>
</template>