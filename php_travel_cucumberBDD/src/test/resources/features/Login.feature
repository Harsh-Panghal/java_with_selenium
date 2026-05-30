Feature: PHPTravels Login Module

  @Smoke @Regression @ExcelData
  Scenario Outline: Validate Login Functionality using Excel
    Given user launches browser
    When user enters login credentials from sheet "<SheetName>" and rownumber <RowNumber>
    And clicks on login button
    Then validate login result

    # Row 0 = Valid, Row 1 = Invalid, Row 2 = Blank User, Row 3 = Blank Pass
    Examples:
      | SheetName | RowNumber |
      | LoginData | 0         |
      | LoginData | 1         |
      | LoginData | 2         |
      | LoginData | 3         |