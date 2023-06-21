import { createRouter, createWebHistory } from 'vue-router'
import HomeComponent from './components/Home.vue'
import BoardComponent from './components/Board.vue'
import ScreenComponent from './components/Screen.vue'
import AboutComponent from './components/About.vue'

const routes = [
    { path: '/', component: HomeComponent },
    { path: '/board', component: BoardComponent },
    { path: '/screen', component: ScreenComponent },
    { path: '/about', component: AboutComponent },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
