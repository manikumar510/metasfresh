package de.metas.migration.cli.rollout_migrate;

import com.google.common.collect.ImmutableSet;

import de.metas.migration.applier.IScriptsApplierListener;
import de.metas.migration.applier.impl.NullScriptsApplierListener;
import de.metas.migration.scanner.IFileRef;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/*
 * #%L
 * de.metas.migration.cli
 * %%
 * Copyright (C) 2017 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

/**
 * This class holds the config from the command line tool's parameters
 *
 * @author metas-dev <dev@metasfresh.com>
 */
@Builder
@Data
public
class RolloutMigrationConfig
{
	public static final String DEFAULT_SETTINGS_FILENAME = "local_settings.properties";

	@Builder.Default
	private boolean canRun = false;

	@NonNull
	@Builder.Default
	private String rolloutDirName = CommandlineParams.DEFAULT_RolloutDirectory;

	/**
	 * If specified, the tools shall load the {@link #dbConnectionSettings} from this file.
	 */
	@Builder.Default
	private String dataBaseSettingsFile = null;

	/**
	 * If specified, the tool shall ignore all files and use these settings.
	 */
	@Builder.Default
	private DBConnectionSettings dbConnectionSettings = null;

	@Builder.Default
	private String scriptFileName = null;

	@Builder.Default
	private IScriptsApplierListener scriptsApplierListener = NullScriptsApplierListener.instance;

	@Builder.Default
	private boolean justMarkScriptAsExecuted = false;

	/**
	 * By default we will check the versions.
	 */
	@Builder.Default
	private boolean checkVersions = true;

	/**
	 * By default we will store our won version in the DB after a successful update.
	 */
	@Builder.Default
	private boolean storeVersion = true;

	/**
	 * If the DB version is already ahead of our local rollout package usually means that something is wrong, so by default the rollout shall fail.
	 */
	@Builder.Default
	private boolean failIfRolloutIsGreaterThanDB = true;

	@Builder.Default
	private String templateDBName = null;

	@Builder.Default
	private String newDBName = null;

	@NonNull
	@Builder.Default
	private ImmutableSet<IFileRef> additionalSqlDirs = ImmutableSet.of();
}
