import java.util.Map;

public record RecordTipoDeCambio(String base_code,
                                 Map<String, Double> conversion_rates){

}
