package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.persistence.FuncionarioDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private static final String BASE_URL = "http://localhost:8080/api/funcionarios";

    public void agregar(FuncionarioDTO funcionario) throws IOException {
        URL url = new URL(BASE_URL + "/guardar");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        // Convertir FuncionarioDTO a JSON usando json-simple
        JSONObject jsonFuncionario = new JSONObject();
        jsonFuncionario.put("cedula", funcionario.getCedula());
        jsonFuncionario.put("nombre", funcionario.getNombre());
        jsonFuncionario.put("clave", funcionario.getClave());

        OutputStream os = conn.getOutputStream();
        os.write(jsonFuncionario.toJSONString().getBytes());
        os.flush();
        os.close();

        conn.getResponseCode(); // Confirma la respuesta
        conn.disconnect();
    }

    public void eliminar(double cedula) throws IOException {
        URL url = new URL(BASE_URL + "/eliminar/" + cedula);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");
        conn.getResponseCode();
        conn.disconnect();
    }

    public void modificar(double cedula, FuncionarioDTO funcionario) throws IOException {
        URL url = new URL(BASE_URL + "/actualizar/" + cedula);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        // Convertir FuncionarioDTO a JSON usando json-simple
        JSONObject jsonFuncionario = new JSONObject();
        jsonFuncionario.put("cedula", funcionario.getCedula());
        jsonFuncionario.put("nombre", funcionario.getNombre());
        jsonFuncionario.put("clave", funcionario.getClave());

        OutputStream os = conn.getOutputStream();
        os.write(jsonFuncionario.toJSONString().getBytes());
        os.flush();
        os.close();

        conn.getResponseCode();
        conn.disconnect();
    }

    public List<FuncionarioDTO> listar() {
        List<FuncionarioDTO> funcionarios = new ArrayList<>();
        try {
            URL url = new URL(BASE_URL + "/listar");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // Parsear JSON usando json-simple
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(sb.toString());
            for (Object obj : jsonArray) {
                JSONObject jsonFuncionario = (JSONObject) obj;
                FuncionarioDTO funcionario = new FuncionarioDTO();
                funcionario.setCedula(((Number) jsonFuncionario.get("cedula")).doubleValue());
                funcionario.setNombre((String) jsonFuncionario.get("nombre"));
                funcionario.setClave((String) jsonFuncionario.get("clave"));
                funcionarios.add(funcionario);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return funcionarios;
    }
}
