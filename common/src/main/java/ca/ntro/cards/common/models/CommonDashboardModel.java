/*
Copyright (C) (2022) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of "Cartes Java", teaching tools made for https://cartesjava.github.io/

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
package ca.ntro.cards.common.models;


import ca.ntro.app.models.Model;
import ca.ntro.cards.common.frontend.views.CommonDashboardView;
import ca.ntro.cards.common.test_cases.CommonTestCaseDatabase;
import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;

public abstract class CommonDashboardModel<DASHBOARD_VIEW     extends CommonDashboardView,
                                           TEST_CASE          extends AbstractTestCaseDescriptor,
                                           TEST_CASE_DATABASE extends CommonTestCaseDatabase>

       implements Model {


	public abstract void addOrUpdateTestCase(TEST_CASE testCaseDescriptor);

	public abstract void displayOn(DASHBOARD_VIEW dashboardView);

	public abstract void loadDbFromDir(TEST_CASE_DATABASE testCaseDatabase);

}
