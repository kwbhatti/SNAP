@aemcore @visual @visual-science_and_space1
Feature: Science and Space Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Science and Pages pages


  Scenario: VCT-SCIENCE_AND_SPACE-001: Science and Space photo gallery full document capture
    Given a user navigates to the ScienceAndSpacePhotoGallery page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
