package org.acme;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 * Resource to get OOM
 */
@Path("oom")
public class OOMResource
{
	/**
	 * Get OOM.
	 */
	@GET
	public void killByOOM()
	{
		final List<byte[]> list = new ArrayList<>();
		var index = 1;
		while (true)
		{
			final var b = new byte[32 * 1024 * 1024]; // 32MB
			list.add(b);
			final var rt = Runtime.getRuntime();
			System.out.printf("[%s] Available heap memory: %s%n", index++, rt.freeMemory());
		}
	}
}
