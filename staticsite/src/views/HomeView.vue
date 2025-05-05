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
    <ul class="options">
      <li>
        <div class="option-container">
          <label class="radio-label">
            <input type="radio" :checked="pick === 'File'" @click="toggleSelection('File')" />
            File
          </label>
          <button class="button is-primary" v-if="pick === 'File'">Choose file</button>
        </div>
      </li>
      <li>
        <div class="option-container">
          <label class="radio-label">
            <input type="radio" :checked="pick === 'List'" @click="toggleSelection('List')" />
            List
          </label>
          <button class="button is-primary" v-if="pick === 'List'">Enter a List</button>
        </div>
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

.option-container {
  display: flex;
  flex-direction: column; /* Stack items vertically */
  align-items: center; /* Center items horizontally */
  margin-bottom: 1rem; /* Add spacing between options */
}

.radio-label {
  display: flex;
  align-items: center; /* Align the radio button and text vertically */
  gap: 0.5rem; /* Add spacing between the radio button and text */
}
</style>