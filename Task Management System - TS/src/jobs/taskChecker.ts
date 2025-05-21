import { getPendingTasks } from '../api/taskClient';

export async function checkPendingTasks() {
  try {
    const tasks = await getPendingTasks();
    console.log('Tarefas pendentes:', tasks);
  } catch (error) {
    console.error('Erro ao buscar tarefas:', error);
  }
}