import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },

  {
    path: '/actor',
    name: 'Actor',
    component: () => import('../views/AddActor.vue')
  },

  {
    path: '/actors',
    name: 'Actors',
    // route level code-splitting
    // this generates a separate chunk (actors.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "actors" */ '../views/Actors.vue')
  },

  {
    path: '/movie',
    name: 'Movie',
    component: () => import('../views/Movies.vue')
  },

  {
    path: '/movies',
    name: 'Movies',
    component: () => import('../views/AddMovie.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router