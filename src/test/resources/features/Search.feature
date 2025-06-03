Feature: Search functionality


  # ─── Basic Search ─────────────────────────────────────────────────
  @basic-search
  Scenario: Entering valid full event name and verify correct results appear
    Given the user has clicked on Search button
    When the user enters 'Heroic Academy' in the search field
    Then all results in Search results contain 'Heroic Academy' string

  @basic-search
  Scenario: Entering valid partial the event name and verify correct results appear
    Given the user has clicked on Search button
    When the user enters 'Heroic' in the search field
    Then all results in Search results contain 'Heroic' string

  @basic-search
  Scenario Outline: Entering valid the event name that contains digits and verify correct results appear
    Given the user has clicked on Search button
    When the user enters '<input>' in the search field
    Then all results in Search results contain '<input>' string

    Examples:
      | input   |
      | 19      |
      | U19     |
      | UFC 286 |

  @basic-search
  Scenario: Enter the event name, then delete character and verify correct results appear
    Given the user has clicked on Search button
    And the user enters 'Milano' in the search field
    When the user deletes last character from the search field
    Then all results in Search results contain 'Milan' string

  @basic-search
  Scenario Outline: Entering valid full name with different casing and verify correct results appear
    Given the user has clicked on Search button
    When the user enters <input> in the search field
    Then all results in Search results contain <input> string

    Examples:
      | input          |
      | heroic academy |
      | HEROIC ACADEMY |
      | Heroic academy |

  @basic-search
  Scenario: Search with leading space and verify correct results appear
    Given the user has clicked on Search button
    When the user enters ' Heroic Academy' in the search field
    Then all results in Search results contain 'Heroic Academy' string

  @basic-search
  Scenario: Search with trailing space and verify correct results appear
    Given the user has clicked on Search button
    When the user enters 'Heroic Academy ' in the search field
    Then all results in Search results contain 'Heroic Academy' string

  @basic-search
  Scenario: Search with multiple spaces between words and verify correct results appear
    Given the user has clicked on Search button
    When the user enters 'Heroic  Academy' in the search field
    Then all results in Search results contain 'Heroic Academy' string

  @basic-search
  Scenario: Loading indicator appears while search results are loading
    Given the user has clicked on Search button
    When the user enters 'Football' in the search field
    Then loading indicator appears while search results are loading

  @basic-search @automated
  Scenario: Close button closes search field
    Given the user has clicked on Search button
    When the user clicks on Close button
    Then search field is not visible

  @basic-search @automated
  Scenario: Clicking on X clears the search input field
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    When the user clicks on X
    Then search input field is empty

  # ─── Search history  ─────────────────────────────────────────────────
  @search-history
  Scenario: Previous search is displayed in Search history
    Given the user has clicked on Search button
    When the user enters 'Heroic Academy' in the search field
    And the user clears the search field
    Then the Search history contains 'Heroic Academy'

  @search-history
  Scenario Outline: Multiple previous searches are recorded in Search history
    Given the user has clicked on Search button
    When the user enters '<first>' in the search field
    And the user clears the search field
    And the user enters '<second>' in the search field
    And the user clears the search field
    Then the Search history contains '<first>'
    And the Search history contains '<second>'

    Examples:
      | first          | second |
      | Heroic Academy | Milan  |

  @search-history
  Scenario: Clicking on item from Search history and verify correct results appear
    Given the user has clicked on Search button
    And the user enters 'Heroic Academy' in the search field
    And the user clears the search field
    When the user selects "Heroic Academy" from Search history
    Then all results in Search results contain 'Heroic Academy' string

  @search-history
  Scenario: 'Clear All' button clears search history and verify search history is empty
    Given the user has clicked on Search button
    When the user enters 'Heroic  Academy' in the search field
    And the user clears the search field
    And the user clicks on Clear All button
    Then the message 'Search History is empty' is present

  # ─── Negative and Boundary ─────────────────────────────────────────────────
  @negative-and-boundary
  Scenario Outline: Search input edge cases and expected behavior
    Given the user has clicked on Search button
    When the user enters '<input>' in the search field
    Then the message '<message>' is present

    Examples:
      | input     | message                                                 |
      | hohbbgew  | There are no results that match your search. Try again. |
      | Heroic%   | There are no results that match your search. Try again. |
      | Heroic%.( | There are no results that match your search. Try again. |
      | FoĆ       | There are no results that match your search. Try again. |
      |           | Search History is empty                                 |

  @negative-and-boundary
  Scenario: Enter search input that exceeds suported number of characters and verify input is trimmed
    Given the user has clicked on Search button
    When the user enters 'VeryLongStringThatCannotFitIn' in the search field
    Then input gets trimmed to 30 characters

  # ─── Search results structure ─────────────────────────────────────────────────
  @search-results-structure @automated
  Scenario: Total search result count matches number of events and competitions shown
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    When search result is not empty
    Then total search result count matches number of events and competitions shown

  @search-results-structure @automated
  Scenario: Total search result count matches sum of counts in tabs
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    When search result is not empty
    Then total search count is sum of counts in tabs

  @search-results-structure
  Scenario: Numbers of events in each tab matches sum of events and competitions shown on that tab
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    When search result is not empty
    Then numbers of events in each tab matches sum of events and competitions shown on that tab

  @search-results-structure
  Scenario: Verify events and competitions are shown under correct tab
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    When search result is not empty
    Then each shown the event and competition are shown under a correct tab

  @search-results-structure
  Scenario: Verify Events table has 7 columns
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    When there are events displayed
    Then Events table has column named 'Events'
    And Events table has column named '1'
    And Events table has column named 'X'
    And Events table has column named '2'
    And Events table has column named 'O'
    And Events table has column named 'U'
    And Events table has column named 'Stats'

  @search-results-structure
  Scenario: Verify each the event has First and Second participant
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    When there are events displayed
    Then each row of the event column contains First event participant
    And each row of the event column contains Second event participant

  @search-results-structure
  Scenario: Verify each the event has the event time
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    When there are events displayed
    Then each row of the event column contains the event time

  @search-results-structure
  Scenario: Verify all events are ordered by the event time (starting with the most recent one)
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    When there are events displayed
    Then events are ordered by the event time

  @search-results-structure @automated
  Scenario: Verify clicking on the event takes you to the event page
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    When there are events displayed
    And the user clicks on one of the events
    Then the user is taken on the clicked the event page

  @search-results-structure
  Scenario: When Starting time is NOT 'Starting Now' nor 'Live' verify each event has the bet odds shown in all columns
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    When there are events displayed
    And the event time is NOT 'Starting Now'
    And the event time is NOT 'Live'
    Then the event has the bet odds shown in all 5 columns

  @search-results-structure
  Scenario: Verify each the event has match stats
    Given the user has clicked on Search button
    When the user enters 'Football' in the search field
    Then each event has match stats shown

  @search-results-structure
  Scenario: When there is the event with the event time 'Live' verify it has period and time displayed
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    When there's an Live event
    Then the event period and time should be displayed

  @search-results-structure
  Scenario: When there is the event with the event time 'Live' verify it has score displayed
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    When there's an Live event
    Then the event score should be displayed

  @search-results-structure
  Scenario: When the event time changes from 'Starting Now' to 'Live' verify score becomes visible
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    And there's an 'Starting Now' event
    When the event time changes to 'Live'
    Then the event score should become visible

  @search-results-structure
  Scenario: Competitions table has 1 column
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    When there are Competitions displayed
    Then Competitions table has 1 column named 'Competition'

  @search-results-structure
  Scenario: When there is Competitions table verify there is at least 1 competition displayed
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    When there is a Competition table
    Then Competitions table has at least 1 row

  # ─── Betting odds interaction ─────────────────────────────────────────────────
  @betting-odds-interaction
  Scenario: When events Starting time is 'Starting Now' verify their the bet odds become invisible
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    When the event time is 'Starting Now'
    Then the event does NOT have the bet odds shown in all 5 columns

  @betting-odds-interaction
  Scenario: When events Starting time is 'Live' verify their the bet odds become invisible
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    When the event time is 'Live'
    Then the event does NOT have the bet odds shown in all 5 columns

  @betting-odds-interaction
  Scenario: When the event time changes to 'Starting Now' verify selected the bet odds become inactive
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    And the user clicks on the bet on a first event
    When the event time changes to 'Starting Now'
    Then the selected the bet becomes inactive

  @betting-odds-interaction
  Scenario: Select one the bet odd and verify it becomes active
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    When the user clicks on the bet '<A>'
    Then the bet '<A>' is active

  @betting-odds-interaction
  Scenario: Select second the bet odd (on the same event) verify it becomes active, while first remains active
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    And the user clicks on the bet '<A>'
    When the user clicks on the bet '<B>'
    Then the bet '<A>' is active
    And the bet '<B>' is active

  @betting-odds-interaction
  Scenario: Select second the bet odd (on a different event) and verify it becomes active while first remains active
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    And the user clicks on a first the bet
    When the user clicks on a second the bet on the same event
    Then the bet '<A>' is active
    And the bet '<B>' is active

  @betting-odds-interaction
  Scenario: When selecting all the bet odds (on the same event) verify they all stay active
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    When the user clicks on a all 5 bet odds on the same event
    Then all 5 bet odds are active

  @betting-odds-interaction
  Scenario: When selecting match stats dropdown verify match stats should become visible
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    When the user clicks on match stats dropdown
    Then the match stats are visible

  @betting-odds-interaction
  Scenario: When unselecting match stats dropdown verify match stats should become invisible
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    And the user clicks on match stats dropdown
    When the user clicks on match stats dropdown
    Then the match stats are NOT visible

  @betting-odds-interaction
  Scenario: When selecting match stats dropdown verify the bet odds remain active
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    And the user clicks on a first the bet
    When the user clicks on match stats dropdown
    Then first the bet is active

  @betting-odds-interaction
  Scenario: the user hovers over the bet and verify it changes style (becomes bold)
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    When the user hovers over one the bet odd
    Then the bet odd field becomes bold

  # ─── Bet slip verificatiions ─────────────────────────────────────────────────
  @bet-slip-verifications
  Scenario: Select one the bet odd and verify it appears to the bet slip
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    When the user clicks on the bet '<A>'
    Then the bet '<A>' is added to the bet slip

  @bet-slip-verifications
  Scenario: Unselect one the bet odd and verify it is removed from the bet slip
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    And the user clicks on the bet
    And the user exits the search
    And the user has clicked on Search button
    And the user selects 'Football' from Search history
    When the user unselects preselected the bet
    Then the bet '<A>' is removed from the bet slip

  @bet-slip-verifications
  Scenario: Select two bet odds and verify bothe are present to the bet slip
    Given the user has clicked on Search button
    And the user enters 'Football' in the search field
    And there are events displayed
    And the user clicks on the bet '<A>'
    And the user clicks on the bet '<B>'
    Then the bet '<A>' is added to the bet slip
    And the bet '<B>' is added to the bet slip

     # ─── Other negative scenarios ─────────────────────────────────────────────────
  @other-negative-scenarios
  Scenario: Perform rapid repeated searches and verify only the last input is processed
    Given the user has clicked on Search button
    When the user quickly enters the following inputs in search field:
      | input    |
      | F        |
      | Fo       |
      | Foo      |
      | Foot     |
      | Footb    |
      | Footba   |
      | Footbal  |
      | Football |
    Then only results for 'Football' are displayed
    And no intermediate results are shown
    And no errors are thrown

  @other-negative-scenarios
  Scenario: Verify graceful handling when search API is unavailable
    Given the user has clicked on Search button
    When the user enters 'Football' in the search field
    And the search API is unavailable
    Then the user sees a message "Something went wrong. Please try again later."
    And no partial or incorrect results are shown
    And the application remains responsive

  @automated
  Scenario: basic sanity
    Given 1 equals 1
    Then 1 should equal 1









