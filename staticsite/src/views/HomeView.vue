<script setup lang="ts">
import { ref } from 'vue'

const pick = ref<string | null>("") // Allow null to represent no selection

// Function to handle radio button selection/deselection
const toggleSelection = (value: string) => {
  pick.value = pick.value === value ? null : value; // Deselect if already selected
}
</script>

<template>
  <main>
    <h1 class="Welcoming">Welcome to the Collatz Sequence Generator!</h1>
    <h2 class="Instruction">Please pick one of the two options below</h2>
    <ul class = "options">
      <li>
        <input type="radio" :checked="pick === 'File'" @click="toggleSelection('File')">
        File
        </input>
        <button class="button is-primary" v-if="pick === 'File'">Choose file</button>
      </li>
      <li>
        <input type="radio" :checked="pick === 'List'" @click="toggleSelection('List')">  List </input>
        <button class="button is-primary" v-if="pick === 'List'">Enter a List</button>
      </li>
    </ul>
  </main>
</template>

<style scoped>
.Welcoming {
  text-align: center;
  font-size: 2rem;
  margin-bottom: 1rem;
}

.Instruction {
  text-align: center;
  font-size: 1.5rem;
  margin-bottom: 2rem;
}

.options {
  list-style-type: none;
  padding: 0;
  text-align: center;
}
</style>