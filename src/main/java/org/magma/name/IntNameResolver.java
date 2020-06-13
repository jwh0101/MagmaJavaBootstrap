package org.magma.name;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import org.magma.Compiler;

import java.util.Optional;

public class IntNameResolver extends AbstractNameResolver {
	@Inject
	protected IntNameResolver(ObjectMapper mapper) {
		super(mapper);
	}

	@Override
	public Optional<JsonNode> resolveName(String name, Compiler compiler) {
		return Optional.of(name)
				.filter("Int"::equals)
				.map(this::wrapInNode);
	}
}
