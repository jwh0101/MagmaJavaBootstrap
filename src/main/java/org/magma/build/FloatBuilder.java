package org.magma.build;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Optional;

public class FloatBuilder implements Builder {
	@Override
	public Optional<String> build(JsonNode node, Builder parent) {
		if (Builder.is(node, "float")) {
			return Optional.of(node.get("value").asDouble() + "f");
		}
		return Optional.empty();
	}
}
