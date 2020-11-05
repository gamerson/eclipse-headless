/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liferay.eclipse.headless.app;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class EclipseApplication implements  IApplication {

	public EclipseApplication() {
	}

	@Override
	public Object start(IApplicationContext applicationContext) throws Exception {
		Map<?, ?> arguments = applicationContext.getArguments();

		Object applicationArgs = arguments.get(IApplicationContext.APPLICATION_ARGS);

		Object result = IApplication.EXIT_OK;

		if (applicationArgs instanceof String[]) {
			String[] args = (String[])applicationArgs;

			if ((args == null) || (args.length < 1)) {
				System.err.println("Not enough arguments, expected usage: \"eclipse-app [<args>]\"");

				result = -1;
			}
			
			System.out.println("args = " + Arrays.stream(args).collect(Collectors.joining(", ")));
		}

		return result;
	}

	@Override
	public void stop() {
	}

}