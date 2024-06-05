<script setup>
import router from './../../router';
// TODO: pull child routes from admin

</script>

<script>
export default {
};
</script>

<template>
    <nav class="navigation-menu">
        <ul>
            <li><router-link :to="{ name: 'Artist'}">Your dashboard</router-link></li>
            <li><router-link :to="{ name: 'ArtistProjectMain'}">All projects</router-link></li>
        </ul>
        <ul v-if="$route.params.projectId">
            <li class="navigation-title">Project</li>
            <li><router-link :to="{ name: 'ArtistProjectSingleDefault'}">Overview</router-link></li>
            <li><router-link :to="{ name: 'ArtistProjectSingleManage'}">Manage</router-link></li>
        </ul>
    </nav>
    
</template>

<style lang="scss" scoped>
    @import './../../../scss/variables';
    .navigation-menu {
        padding: 20px 0;
        background: lighten($dark, 15%);
        color: $light;
        transition: 200ms;
        pointer-events: none;
        visibility: hidden;
        opacity: 0;
        transform: translateY(-100%);
        position: fixed;
        width: 100%;
        top: 50px;
        ul {
            list-style: none;
            display: flex;
            flex-direction: column;
            padding: 0;
            margin: 0;
            li {
                display: flex;
                a {
                    all: unset;
                    font-family: inherit;
                    padding: 12px 0 12px 30px;
                    font-size: 14px;
                    &.router-link-active {
                        font-weight: 700;
                    }
                }
                &.navigation-title {
                    padding: 24px 0 0.5em 30px;
                    color: darken($white, 50%);
                    text-transform: uppercase;
                    border-bottom: 1px solid rgba($white, 0.1);
                    font-size: 12px;
                    font-weight: 600;
                    font-weight: 700px;
                }
            }
        }
        &.active {
            pointer-events: all;
            visibility: visible;
            opacity: 1;
            transform: translateY(0);
        }
    }
</style>