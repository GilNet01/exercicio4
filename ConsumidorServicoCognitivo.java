package exercicio4;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.models.DocumentSentiment;

public class ConsumidorServicoCognitivo {

    public static void main(String[] args) {
        
        String ENDPOINT = "https://analise-sentiment.cognitiveservices.azure.com/"; 
        String CHAVE_API = "1neQX0gRsIEc0wL6EV8fqF6FjEWABt0clhywIVETzPp3IUrNXcA0JQQJ99BJACZoyfiXJ3w3AAAaACOGEp8U"; 
        
        String textoParaAnalise = "Estou muito feliz e animado por completar todas as etapas da atividade!";

        TextAnalyticsClient cliente = new TextAnalyticsClientBuilder()
                .credential(new AzureKeyCredential(CHAVE_API))
                .endpoint(ENDPOINT)
                .buildClient();

        System.out.println("--- RESULTADO DA ANÁLISE DE SENTIMENTO ---");
        System.out.println("Texto Enviado: \"" + textoParaAnalise + "\"");

        try {

            DocumentSentiment resultado = cliente.analyzeSentiment(textoParaAnalise);

            System.out.println("Sentimento Classificado: " + resultado.getSentiment().toString());
            System.out.println("Confiança Positiva: " + resultado.getConfidenceScores().getPositive());
            System.out.println("Confiança Negativa: " + resultado.getConfidenceScores().getNegative());

        } catch (Exception e) {
            System.out.println("Erro ao conectar ou processar: " + e.getMessage());
        }
    }
}
