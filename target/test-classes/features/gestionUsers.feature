Feature: Gestion des utilisateurs

  Background: Authntification et navigation page Admin
    Given l'utilisateur est sur la page de connexion
    When il saisit le login "Admin" et le mot de passe "admin123"
    Then il est redirigé vers la page d'accueil
    And je clique sur l'onglet "Admin"

  @admin
  Scenario: Ajout d'un utilisateur
    Given je clique sur le bouton "Add" pour ajouter un utilisateur
    When je renseigne les champs pour la création d'un utilisateur avec les informations suivantes
      | Username         | Test@1234 |
      | Password         | Test@1234 |
      | Confirm Password | Test@1234 |
    And je selectionne les valeurs suivantes dans les listes déroulantes
      | User Role | ESS     |
      | Status    | Enabled |
    And je selectionne le nom de l'employé "Charles Carter"


  @dashboard
  Scenario: Ajout d'un utilisateur
    Given je clique sur l'onglet "Dashboard"


