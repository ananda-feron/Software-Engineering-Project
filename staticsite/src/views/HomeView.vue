<script setup lang="ts">
</script>

<template>
  <main>
    <ul>
    <li><input type="radio" v-model="pick" :value="first" /></li>
    <li><input type="radio" v-model="pick" :value="second" /></li>
    </ul>
  </main>
</template>
