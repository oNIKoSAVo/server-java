<template>
  <div class="app-main-layout">
    
    <NavBar @click="isOpen = !isOpen" />

    <SideBar v-model="isOpen" />
    
    <main class="app-content" :class="{full: !isOpen}">
      <div class="app-page">
        <router-view />
      </div>
    </main>
  </div>
</template>

<script>
import NavBar from '@/components/app/NavBar'
import SideBar from '@/components/app/SideBar'

export default {
  name: 'main-layout',
  data: () => ({
    isOpen: true
  }),
  components: {
    NavBar, SideBar
  }
}
</script>
