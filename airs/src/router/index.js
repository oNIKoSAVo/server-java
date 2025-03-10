import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'listTweets',
      meta: {layout: 'main'},
      component: () => import('../views/ListTweets.vue')
    },
    {
      path: '/feedbackChart',
      name: 'feedbackChart',
      meta: {layout: 'main'},
      component: () => import('../views/FeedbackChart.vue')
    },
    {
      path: '/reasonsNegativity',
      name: 'reasonsNegativity',
      meta: {layout: 'main'},
      component: () => import('../views/ReasonsNegativity.vue')
    }
  ]
})
