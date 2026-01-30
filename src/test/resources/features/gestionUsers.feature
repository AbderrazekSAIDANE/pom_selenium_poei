Feature: Gestion des utilisateurs
  Background: Authntification et navigation page Admin
    Given l'utilisateur est sur la page de connexion
    When il saisit le login "Admin" et le mot de passe "admin123"
    Then il est redirigé vers la page d'accueil
    And je clique sur l'onglet "Admin"

  @creationUser
  Scenario: Ajout d'un utilisateur
    Given je clique sur le bouton "Add" pour ajouter un utilisateur
    When je renseigne les champs pour la création d'un utilisateur avec les informations suivantes
      | Username         | Aest@9292 |
      | Password         | Test@1234 |
      | Confirm Password | Test@1234 |
    And je selectionne les valeurs suivantes dans les listes déroulantes
      | User Role | ESS     |
      | Status    | Enabled |
    And je selectionne le nom de l'employé "Ranga Akunuri"
    And je clique sur le bouton "Save"
    And l'utilisateur "Aest@9292" a bien été créé

  @modificationUser
  Scenario: Modification sur un utilisateur
    Given je clique sur le bouton modifier de l'utilisateur "Aest@9292"
    When je modiffie le champs "Username" par la valeur "Aest@9145"
    And je clique sur le bouton "Save"
    Then la modification sur la fiche de l'utilisateur "Aest@9145" a bien été pris en compte


