<script setup>
import { projectdata } from './../../datamock';
import router from './../../router';

let project = null;
const projectId = router.currentRoute.value.params.projectId;


// Find project in mock data, can be replaced with an API call to get a single project.
if (projectdata.some(item => item.id === projectId)) {
  project = projectdata.filter(item => item.id === projectId)[0];
  console.log(project);
}

</script>

<template>
  <div>
    <header class="page-header">
        <div class="back-button" @click="$router.go(-1)"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-chevron-left"><polyline points="15 18 9 12 15 6"></polyline></svg></div>
        <h1>{{project != null ? project.name: "Project not found"}}</h1>
        <div></div>
    </header>
  </div>
  <router-view></router-view>
</template>
<script>
export default {
  data() {
    return {
      titleSuffix: 'info',
    }
  }
}

</script>