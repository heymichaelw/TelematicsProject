import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.HashMap;


public class TelematicsService {
    static void report(VehicleInfo vehicleInfo){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("json/" +vehicleInfo.getVIN() + ".json"), vehicleInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("json/.");
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")){
                ObjectMapper mapper = new ObjectMapper();
                VehicleInfo value = null;
                try {
                    value = mapper.readValue(new File(f.getAbsolutePath()), VehicleInfo.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    objectMapper.writeValue(new File("html/" + value.getVIN() + ".html"), reportDashboard(value));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static  String reportDashboard(VehicleInfo vehicleInfo){
        String htmlTemplate = "<html>" +
                "<title>" +
                "Vehicle Telematics Dashboard" +
                "</title>" +
                "<body>" +
                "<table align='center'>" +
                "<tr>" +
                "<th>" +
                "Odometer (miles) |" +
                "</th>" +
                "<th>" +
                "Consumption (gallons) |" +
                "</th>" +
                "<th>" +
                "Last Oil Change |" +
                "</th>" +
                "<th>" +
                "Engine size (liters)" +
                "</th>" +
                "</tr>" +
                "<tr>" +
                "<td align='center'>" +
                "%s" +
                "</td>" +
                "<td align='center'>" +
                "%s" +
                "</td>" +
                "<td align='center'>" +
                "%s" +
                "</td>" +
                "<td align='center'>" +
                "%s" +
                "</td>" +
                "</tr>" +
                "</table>" +
                "</body>" +
                "</html>";
        HashMap<String, Object> context = new HashMap<>();
        context.put("odometer", vehicleInfo.getOdometer());
        context.put("consumption", vehicleInfo.getGallonsUsed());
        context.put("lastService", vehicleInfo.getOdometerAtLastService());
        context.put("engine", vehicleInfo.getEngineSize());

        return String.format(htmlTemplate, context.get("odometer"), context.get("consumption"), context.get("lastService"), context.get("engine"));
    }
}
