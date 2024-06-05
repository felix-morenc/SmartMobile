<script setup>
import { projectdata } from './../../datamock';
</script>

<script>
export default {}
</script>

<template>
  <div>
    <header class="page-header">
        <h1>Projects</h1> 
    </header>
    <div class="project-list">
      <router-link class="project" v-for="project in projectdata" :key="project" :to="{ name: 'ArtistProjectSingleDefault', params: { projectId: project.id }}">
        <span class="project__title">{{project.name}}</span>
        <div class="project__date">
          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-calendar"><rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect><line x1="16" y1="2" x2="16" y2="6"></line><line x1="8" y1="2" x2="8" y2="6"></line><line x1="3" y1="10" x2="21" y2="10"></line></svg>
          <span>{{project.date}}</span>
        </div>
      </router-link>
    </div>
  </div>
  <router-view></router-view>
</template>

<style lang="scss" scoped>
@import './../../../scss/variables';
  .project-list {
    display: flex;
    flex-wrap: wrap;
    width: 100%;
    .project {
      text-decoration: none;
      width: 100%;
      margin-bottom: 20px;
      display: flex;
      flex-direction: column;
      background: linear-gradient(145deg, $secondary, adjust-hue($secondary, -11deg));
      color: $dark;
      padding: 18px;
      border-radius: 15px;
      .project__title {
        font-size: 22px;
        font-weight: 500;
        margin-bottom: 20px;
      }
      .project__date {
        font-size: 14px;
        font-style: italic;
        display: flex;
        align-items: center;
        svg {
          width: 15px;
          height: 15px;
        }
      }
    }
  }
</style>