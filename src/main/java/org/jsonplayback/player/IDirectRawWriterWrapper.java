package org.jsonplayback.player;

import java.util.function.Function;

public interface IDirectRawWriterWrapper {
	LazyProperty getJsHbLazyProperty();
	IDirectRawWriter getCallback();
}
