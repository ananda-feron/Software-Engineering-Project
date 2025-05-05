<script setup lang="ts">
import { ref } from 'vue'

const pick = ref("File")
</script>

<template>
  <main>
    <h1>Welcome to the Collatz Sequence Generator!</h1>
    <h2>Please pick one of the two options below</h2>
    <ul>
    <li ><input type="radio" v-model="pick" value="File" /> File </li>
    <li ><input type="radio" v-model="pick" value="List" /> List </li>
    </ul>
  </main>
</template>
