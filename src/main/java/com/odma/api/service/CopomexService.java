package com.odma.api.service;

import java.util.List;
import java.util.Map;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.odma.api.dto.DireccionDTO;
import com.odma.api.exception.CopomexApiException;

@Service
public class CopomexService {

	@Value("${copomex.api.token}")
	private String token;

	@Value("${cupomex.api.url}")
	private String apiUrl;

	private final ObjectMapper objectMapper = new ObjectMapper();

	private final CloseableHttpClient httpClient = HttpClients.createDefault();

	public DireccionDTO obtenerDireccionPorCodigoPostal(String codigoPostal) {
		String url = apiUrl + "/info_cp/" + codigoPostal + "?token=" + token;

		HttpGet request = new HttpGet(url);
		request.addHeader("Accept", "application/json");

		try (ClassicHttpResponse response = httpClient.executeOpen(null, request, null)) {
			int statusCode = response.getCode();
			String json = EntityUtils.toString(response.getEntity());

			if (statusCode != 200) {
				throw new CopomexApiException("Error en API SEPOMEX. Código HTTP: " + statusCode);
			}

			List<Map<String, Object>> lista = objectMapper.readValue(json, new TypeReference<>() {
			});
			Map<String, Object> responseMap = (Map<String, Object>) lista.get(0).get("response");

			if (responseMap == null || responseMap.isEmpty()) {
				throw new CopomexApiException("No se encontró información para el CP " + codigoPostal);
			}

			String estado = (String) responseMap.get("estado");
			String municipio = (String) responseMap.get("municipio");
			String asentamiento = (String) responseMap.get("asentamiento");

			return new DireccionDTO(estado, municipio, asentamiento);

		} catch (Exception e) {
			throw new CopomexApiException("Error al consumir API SEPOMEX", e);
		}
	}

}
