package model;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil<T> {
    private final Gson gson = new Gson();

    public void guardarDatos(List<T> lista, String folder) throws IOException {
        try (FileWriter writer = new FileWriter(folder)) {
            gson.toJson(lista, writer);
        }
    }

    public List<T> leerDatos(String folder, Type tipoLista) throws IOException {
        try (FileReader reader = new FileReader(folder)) {
            return gson.fromJson(reader, tipoLista);
        }
    }
}
