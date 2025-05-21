import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api', // ajuste conforme sua API Spring
});

export async function getPendingTasks() {
  const response = await api.get('/tasks?status=PENDING');
  return response.data;
}