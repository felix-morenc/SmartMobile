<script setup >
import PieChart from '../../../components/PieChart.vue';
import LineChart from '../../../components/LineChart.vue';
import router from './../../../router';

const projectId = router.currentRoute.value.params.projectId;
</script>

<template>
  <div class="project-info">
    Your show has: <b>5 lights & 3 song types</b> <br/>
    <router-link class="btn btn--white btn--inline" :to="{ name: 'ArtistProjectSingleManage', params: { projectId: projectId }}">Manage show</router-link>
  </div>
  <div class="infographic infographic--important">
    <h2>Summary</h2>
    <ul>
      <li>Engagement was highest with your most popular songs</li>
      <li>Your audience didn't like pink lights, probably due to your songs being mostly <b>metal</b></li>
    </ul>
    <small>Generated by <b>tensorflow</b></small>
  </div>
  
  <div class="infographic">
    <h2>Engagement</h2>
    <LineChart :chart-data="engagementChartData"/>
    <div class="infographic__description">
      Passive engagement means the user sometimes interacts with the show. Active engagement means the user interacts frequently.<br/>
    </div>
  </div>
  <div class="infographic">
    <h2>Popular light choices</h2>
    <PieChart :chart-data="popularLightsData"/>
  </div>
</template>
<script>

export default {
    components: { PieChart, LineChart },
    data() {
      return {
        engagementChartData: {
        labels: [ '11:00', '11:10', '11:20', '11:30', '11:40', '11:50', '12:00', '12:10', '12:20', '12:30'],
        datasets: [
          {
            label: 'No engagement',
            backgroundColor: '#E46651',
            data: [4, 12, 5, 4, 2, 1, 7, 3, 1, 3]
          },
          {
            label: 'Passive engagement',
            backgroundColor: '#41B883',
            data: [12, 13, 17, 5, 4, 3, 12, 4, 5, 6]
          },
          {
            label: 'Active engagement',
            backgroundColor: '#00D8FF',
            data: [22, 32, 27, 32, 39, 42, 24, 50, 32, 40, 35]
          }
        ]
      },
      popularLightsData: {
        labels: [ 'Green', 'Blue', 'Red', 'Pink', 'Purple'],
        datasets: [
          {
            label: 'Data One',
            backgroundColor: ['#41B883', '#00D8FF', '#E46651', '#fc03e3', '#9d03fc'],
            data: [11, 34, 12, 4, 19]
          }
        ]
      }
      }
    }
}
</script>

<style lang="scss" scoped>
@import './../../../../scss/variables';

    .project-info {
      background: $primary;
      color: $white;
      border-radius: 10px;
      padding: 10px;
    }

  .infographic {
    background: rgba($dark, 0.1);
    padding: 10px;
    border-radius: 10px;
    margin: 15px 0 10px;
    h2 {
      margin: 0 0 20px;
    }
    .infographic__description {
      background: rgba($dark, 0.1);
      padding: 10px;
      border-radius: 10px;
      margin: 15px 0 0;
    }
    &.infographic--important {
      background: rgba($secondary, 0.2);
    }
  }
</style>