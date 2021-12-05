package com.example.scheduletest.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleTestService {

    /*
     * fixDelay garante que haja um atraso de n milissegundos entre o tempo de
     * término de uma
     * tarefa e o horário de início da próxima execução da tarefa.
     * Esta propriedade é especificamente útil quando precisamos ter certeza de que
     * apenas uma
     * instância da tarefa é executada o tempo todo. Para trabalhos dependentes, é
     * muito útil
     */
    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
    }

    /**
     * A propriedade fixedRate executa a tarefa programada a cada n milissegundo.
     * Não verifica se há execuções anteriores da tarefa.
     *
     * Isso é útil quando todas as execuções da tarefa são independentes.
     * Se não esperamos exceder o tamanho da memória e do pool de rosca,
     * o fixedRate deve ser bastante útil.
     * 
     * Embora, se as tarefas recebidas não terminarem rapidamente,
     * é possível que elas acabem com "Exceção Fora da Memória".
     * 
     */

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        System.out.println(
                "Fixed rate task - " + System.currentTimeMillis() / 1000);
    }

    /**
     * A tarefa será executada pela primeira vez após o valor inicial daDelay,
     * Esta opção é conveniente quando a tarefa tem uma configuração que precisa ser
     * concluída.
     */

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleFixedRateWithInitialDelayTask() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "Fixed rate task with one second initial delay - " + now);
    }

    /**
     * Dá tambem para utilizar expressões cron 
     */
    @Scheduled(cron = "0 15 10 15 * ?")
    public void scheduleTaskUsingCronExpression() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "schedule tasks using cron jobs - " + now);
    }
}
