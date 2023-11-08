<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
</script>

<template>
  <header>
    <nav class="flex w-full justify-end items-center px-10 py-5 absolute">
      <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="50" height="50" />
      <RouterLink class="p-5" to="/">Home</RouterLink>
      <RouterLink class="p-5" to="/about">About</RouterLink>
    </nav>
  </header>

  <RouterView />
</template>
