package org.magma.parse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import org.magma.Extractor;
import org.magma.JSONUnit;

import java.util.Optional;

/**
 * Parsers integers using {@link Integer#parseInt(String)}.
 */
public class IntParser extends JSONUnit implements Parser {
	@Inject
	public IntParser(ObjectMapper mapper) {
		super(mapper);
	}

	/**
	 * Attempts to parse the content using {@link Integer#parseInt(String)},
	 * and returns an empty result if a {@link NumberFormatException} was thrown.
	 *
	 * @param content <p>The content that is to be parsed.
	 *                Should already be trimmed using {@link String#trim()}, and
	 *                should not be null.
	 *                </p>
	 * @param extractor
	 * @return The wrapped integer.
	 */
	@Override
	public Optional<JsonNode> parse(String content, Extractor extractor) {
		try {
			int result = Integer.parseInt(content);
			return buildNode(result);
		} catch (NumberFormatException e) {
			return Optional.empty();
		}
	}

	private Optional<JsonNode> buildNode(int result) {
		return Optional.of(createObject()
				.put("type", "integer")
				.put("value", result));
	}
}
