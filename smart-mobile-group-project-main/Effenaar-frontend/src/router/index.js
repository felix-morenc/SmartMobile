import {createRouter, createWebHistory} from 'vue-router'
import Map from './../views/Map.vue'
import Artist from './../views/Artist.vue';
import Project from './../views/Artist/Project.vue';
import ProjectSingle from './../views/Artist/ProjectSingle.vue';
import ProjectDefault from './../views/Artist/Project/Default.vue';
import ProjectManage from './../views/Artist/Project/Manage.vue';
import ProjectManagePreset from './../views/Artist/Project/ManagePreset.vue';
import Voting from './../views/Voting.vue'
import LiveStream from './../views/LiveStream.vue'

const routes = [
  {path: '/', name: 'Home', component: Map},
  {path: '/voting', name: 'Voting', component: Voting},
  {path: '/liveStream/:id', name: 'LiveStream', component: LiveStream},
  {path: '/artist', name: 'Artist', component: Artist,
  children: [
    {path: 'project', name: 'ArtistProjectMain', component: Project},
    {path: 'project/:projectId', name: 'ArtistProjectSingle', component: ProjectSingle,
    children: [
      {path: '', name: 'ArtistProjectSingleDefault', component: ProjectDefault},
      {path: 'manage', name: 'ArtistProjectSingleManage', component: ProjectManage },
      {path: 'manage/:preset', name: 'ArtistProjectSingleManagePreset', component: ProjectManagePreset}
    ]
  }
  ]},
]

const router = createRouter({
  history: createWebHistory(),
  routes
})
export default router 