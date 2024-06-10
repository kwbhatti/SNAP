@aemcore @visual @visual-env_and_energy
Feature: Environment and Energy Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Environment and Energy pages


  Scenario: VCT-ENV_AND_ENERGY-001: Environment and Energy article image lead full document capture
    Given a user navigates to the EnvAndEnergyArticleImageLead page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
                                                                            